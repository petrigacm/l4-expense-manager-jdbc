package sk.stopangin.expensemanager;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import sk.stopangin.expensemanager.config.RootConfig;
//import sk.stopangin.expensemanager.config.WebConfig;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//public class Runner2 implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        ApplicationContext rootApplicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
//
//        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        webApplicationContext.setParent(rootApplicationContext);
//        webApplicationContext.register(WebConfig.class);
//        webApplicationContext.setServletContext(servletContext);
//        webApplicationContext.refresh();
//
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
//        ServletRegistration registration = servletContext.addServlet("app", dispatcherServlet);
//        registration.addMapping("/");
//    }
//}
