package link.hiroshisprojects.hibernate;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import link.hiroshisprojects.hibernate.config.AspectConfig;
import link.hiroshisprojects.hibernate.config.JpaConfig;
import link.hiroshisprojects.hibernate.config.WebMvcConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { JpaConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebMvcConfig.class, AspectConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


}
