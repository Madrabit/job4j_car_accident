package ru.job4j.accident;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.job4j.accident.config.WebConfig;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @author madrabit on 15.09.2020
 * @version 1$
 * @since 0.1
 */
public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletCxt) {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(WebConfig.class);
        ac.refresh();
        AccidentMem repository = ac.getBean(AccidentMem.class);
        //Test @Repository
        repository.store(new Accident(1, "Petr", "lalala", "Spb"));
        repository.store(new Accident(2, "Andrew", "hohoho", "Msk"));
        Accident accident = repository.retrieve(1);
        System.out.println(accident);

        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
