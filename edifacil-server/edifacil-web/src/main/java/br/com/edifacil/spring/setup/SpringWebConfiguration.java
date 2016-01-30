package br.com.edifacil.spring.setup;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

//@EnableWebMvc
//@Configuration
//@ComponentScan(basePackages = "br.com.ichei")
public class SpringWebConfiguration extends WebMvcConfigurerAdapter {
	
	/** logger. */
	private final static Logger LOGGER = LoggerFactory.getLogger(SpringWebConfiguration.class);
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/**
	 * Configuração do thymeleaf
	 * @return {@link ServletContextTemplateResolver}
	 */
	@Bean
	public ServletContextTemplateResolver templateResolver() {
		
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/WEB-INF/app/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		
		if (LOGGER.isDebugEnabled()) {
			resolver.setCacheable(false);
		}
		else {
			resolver.setCacheable(true);
		}
		
		resolver.setCharacterEncoding("UTF-8");
		
		return resolver;

	}

	/**
	 * Engine com os dialetos {@link LayoutDialect} e {@link ConditionalCommentsDialect}.
	 * @return {@link SpringTemplateEngine}
	 */
	public SpringTemplateEngine templateEngine() {
		
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect()); 
		engine.addDialect(new ConditionalCommentsDialect());
		
		return engine;
	}

	/**
	 * View resolver default da aplicação.
	 * @return {@link ThymeleafViewResolver}
	 */
	@Bean
	public ViewResolver viewResolver() {

		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[]{"*"});
		
		if (LOGGER.isDebugEnabled()) {
			viewResolver.setCache(false);
		}
		else {
			viewResolver.setCache(true);
		}		
		
		return viewResolver;
	}

	@Bean
	public LocaleResolver localeResolver() {

		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("pt"));
		
		return cookieLocaleResolver;
	}
	
	@Bean
    public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(3545728l); //3MB
		return multipartResolver;
	}
    
}