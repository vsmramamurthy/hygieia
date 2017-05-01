package com.capitalone.dashboard.config;
 
 import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.capitalone.dashboard.repository.AuthenticationRepository;
import com.capitalone.dashboard.repository.DashboardRepository;
import com.capitalone.dashboard.repository.UserInfoRepository;
import com.capitalone.dashboard.service.AuthenticationService;
import com.capitalone.dashboard.service.BinaryArtifactService;
import com.capitalone.dashboard.service.BuildService;
import com.capitalone.dashboard.service.CloudInstanceService;
import com.capitalone.dashboard.service.CloudSubnetService;
import com.capitalone.dashboard.service.CloudVirtualNetworkService;
import com.capitalone.dashboard.service.CloudVolumeService;
import com.capitalone.dashboard.service.CodeQualityService;
import com.capitalone.dashboard.service.CollectorService;
import com.capitalone.dashboard.service.CommitService;
import com.capitalone.dashboard.service.DashboardService;
import com.capitalone.dashboard.service.DefaultAuthenticationServiceImpl;
import com.capitalone.dashboard.service.DeployService;
import com.capitalone.dashboard.service.EncryptionService;
import com.capitalone.dashboard.service.FeatureService;
import com.capitalone.dashboard.service.PipelineService;
import com.capitalone.dashboard.service.ScopeService;
import com.capitalone.dashboard.service.ServiceService;
import com.capitalone.dashboard.service.TeamService;
import com.capitalone.dashboard.service.TestResultService;
import com.capitalone.dashboard.service.UserInfoService;
import com.capitalone.dashboard.service.UserInfoServiceImpl;
import com.capitalone.dashboard.util.PaginationHeaderUtility;
 
 @SpringBootApplication
 @ComponentScan(basePackages = {"com.capitalone.dashboard.auth"})
 public class TestDefaultAuthConfig {
 
 	@Bean
 	public DashboardRepository dashboardRepository() {
 		return Mockito.mock(DashboardRepository.class);
 	}
 	
 	@Bean
 	public AuthenticationRepository authenticationRepository() {
 		return Mockito.mock(AuthenticationRepository.class);
 	}
 	
 	@Bean
 	public UserInfoRepository userInfoRepository() {
 		return Mockito.mock(UserInfoRepository.class);
 	}
 	
 	@Bean
     public UserInfoService userInfoService() {
         return new UserInfoServiceImpl(userInfoRepository());
     }
 	
 	@Bean
 	public AuthenticationService authenticationService() {
 		return new DefaultAuthenticationServiceImpl(authenticationRepository());
 	}
 	
 	@Bean
 	public DashboardService dashboardService() {
 		return Mockito.mock(DashboardService.class);
 	}
 
 	@Bean
 	public BuildService buildService() {
 		return Mockito.mock(BuildService.class);
 	}
 
 	@Bean
 	public CollectorService collectorService() {
 		return Mockito.mock(CollectorService.class);
 	}
 
 	@Bean
 	public ServiceService serviceService() {
 		return Mockito.mock(ServiceService.class);
 	}
 
 	@Bean
 	public DeployService deployService() {
 		return Mockito.mock(DeployService.class);
 	}
 
 	@Bean
 	public CloudSubnetService cloudService() {
 		return Mockito.mock(CloudSubnetService.class);
 	}
 
 	@Bean
 	public CodeQualityService codeQualityService() {
 		return Mockito.mock(CodeQualityService.class);
 	}
 
 	@Bean
 	public CommitService commitService() {
 		return Mockito.mock(CommitService.class);
 	}
 
 	@Bean
 	public TestResultService testResultService() {
 		return Mockito.mock(TestResultService.class);
 	}
 
 	@Bean
 	public FeatureService featureService() {
 		return Mockito.mock(FeatureService.class);
 	}
 
 	@Bean
 	public ScopeService scopeService() {
 		return Mockito.mock(ScopeService.class);
 	}
 	
 	@Bean
 	public EncryptionService encryptionService() {
 		return Mockito.mock(EncryptionService.class);
 	}
 
     @Bean
     public BinaryArtifactService artifactService() {
         return Mockito.mock(BinaryArtifactService.class);
     }
 
 	@Bean
 	public PipelineService pipelineService() {
 		return Mockito.mock(PipelineService.class);
 	}
 
     @Bean
     public CloudInstanceService cloudInstanceService() {
         return Mockito.mock(CloudInstanceService.class);
     }
 
     @Bean
     public CloudSubnetService cloudSubnetService() {
         return Mockito.mock(CloudSubnetService.class);
     }
 
     @Bean
     public CloudVirtualNetworkService cloudVirtualNetworkService() {
         return Mockito.mock(CloudVirtualNetworkService.class);
     }
 
     @Bean
     public CloudVolumeService cloudVolumeService() {
         return Mockito.mock(CloudVolumeService.class);
     }
     
     @Bean
     public TeamService teamService() {
    	 return Mockito.mock(TeamService.class);
     }
     
     @Bean
     public PaginationHeaderUtility paginationHeaderUtility() {
         return Mockito.mock(PaginationHeaderUtility.class);
     }
 }
