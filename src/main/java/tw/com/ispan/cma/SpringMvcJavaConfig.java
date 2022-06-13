package tw.com.ispan.cma;

import java.util.Locale;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ServletComponentScan
@EnableTransactionManagement
public class SpringMvcJavaConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("langctry");
		registry.addInterceptor(interceptor);
	}
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName("langCookie");
		resolver.setCookieMaxAge(864000);
		resolver.setDefaultLocale(new Locale("es", "ES"));
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setBasename("error.Messages");
		rbms.setDefaultEncoding("UTF-8");
		rbms.setFallbackToSystemLocale(false);
		return rbms;
	}

	//這是從老師MVC摳過來的，現在要試兩個ResolverConfig看成不成功
	//PS這個一開始就沒用處了(就算pom把thymeleaf刪掉)
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(InternalResourceView.class);
//		resolver.setPrefix("/WEB-INF/views");
//		resolver.setSuffix(".jsp");
//		registry.viewResolver(resolver);
//	}
}
