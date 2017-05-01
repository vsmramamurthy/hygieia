/**
 * Controller for administrative functionality
 */
(function () {
    'use strict';

    angular
        .module(HygieiaConfig.module)
        .controller('AdminController', AdminController);


    AdminController.$inject = ['dashboardData', '$location','$uibModal', 'userService', 'authService'];
    function AdminController(dashboardData, $location, $uibModal, userService, authService) {
        var ctrl = this;
        if (userService.isAuthenticated() && userService.isAdmin()) {
            $location.path('/admin');
        }
        else {
            console.log("Not authenticated redirecting");
            $location.path('#');
        }

        ctrl.storageAvailable = localStorageSupported;
        ctrl.showAuthentication = userService.isAuthenticated();
        ctrl.templateUrl = "app/dashboard/views/navheader.html";
        ctrl.username = userService.getUsername();
        ctrl.login = login;
        ctrl.logout = logout;
        ctrl.renameDashboard=renameDashboard;

        // list of available themes. Must be updated manually
        ctrl.themes = [
            {
                name: 'Dash',
                filename: 'dash'
            },
            {
                name: 'Dash for display',
                filename: 'dash-display'
            },
            {
                name: 'Bootstrap',
                filename: 'default'
            },
            {
                name: 'BS Slate',
                filename: 'slate'
            }];

        // used to only show themes option if local storage is available
        if(localStorageSupported) {
            ctrl.theme = localStorage.getItem('theme');
        }


        // ctrl.dashboards = []; don't default since it's used to determine loading

        // public methods
        ctrl.deleteDashboard = deleteDashboard;
        ctrl.applyTheme = applyTheme;


        // request dashboards
        dashboardData.search().then(processResponse);


        //implementation of logout
        function logout() {
            authService.logout();
            $location.path("/login");
        }

        function login() {
          $location.path("/login")
        }

        // method implementations
        function applyTheme(filename) {
            if(localStorageSupported) {
                localStorage.setItem('theme', filename);
                location.reload();
            }
        }

        function deleteDashboard(id) {
            dashboardData.delete(id).then(function() {
                _.remove(ctrl.dashboards, {id: id});
            });
        }

        function renameDashboard(item)
        {
            console.log("Rename Dashboard in Admin");

            var mymodalInstance=$uibModal.open({
                templateUrl: 'app/dashboard/views/renameDashboard.html',
                controller: 'RenameDashboardController',
                controllerAs: 'ctrl',
                resolve: {
                    dashboardId: function() {
                        return item.id;
                    },
                    dashboardName: function() {
                        return item.name;
                    }
                }
            });

            mymodalInstance.result.then(function(condition) {
                window.location.reload(false);
            });

        }


        function processResponse(data) {
            ctrl.dashboards = [];
            for (var x = 0; x < data.length; x++) {
                ctrl.dashboards.push({
                    id: data[x].id,
                    name: data[x].title
                });
            }
        }
    }
})();
