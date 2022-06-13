package tw.com.ispan.cma.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import tw.com.ispan.cma.SpringMvcJavaConfig;

public class DispatcherServletRegister extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringJavaConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMvcJavaConfig.class};
	}


//	亂側的好像不用打這兩個有標示＠Config就會自動執行了
//	@Override
//	protected Class<?>[] getThymeleafViewResolverConfig() {
//		return new Class[] {ThymeleafViewResolverConfig.class};
//	};
//	@Override
//	protected Class<?>[] getJspViewResolverConfig() {
//		return new Class[] {JspViewResolverConfig.class};
//	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
