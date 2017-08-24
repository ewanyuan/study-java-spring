package ewan.study.web.controller;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import ewan.study.service.LazyInitHolderSingleton;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}

	@RequestMapping(value = "/testGC", method = RequestMethod.GET)
	@ResponseBody
	public String testGC() throws InterruptedException {
		int j = 0;
		List bytes = new ArrayList();
		for (int i = 0; i < 10; i++) {
			bytes.add(new byte[1*1024*1024]);
		}
		j = bytes.size();
		bytes.clear();
		return j + ";";
	}
}