package ewan.study.web.controller;

import ewan.study.service.event.Visitor;
import ewan.study.service.proxy.DynamicProxyDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring MVC Hello World");
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

	@Autowired
	private Visitor visitor;

	@RequestMapping(value = "/visitorComing", method = RequestMethod.GET)
	@ResponseBody
	public void visitorComing() throws InterruptedException {

		visitor.setName("ZHANGSAN");
		visitor.knockAtDoor();
	}

	@Autowired
	private DynamicProxyDemo.UserDao userDaoProxyByJdk;

	@RequestMapping(value = "/JDP", method = RequestMethod.GET)
	@ResponseBody
	public void javaDynamicProxy() throws InterruptedException {

		userDaoProxyByJdk.add();
	}

	@Autowired
	private DynamicProxyDemo.UserDao userDaoProxyByCglib;

	@RequestMapping(value = "/CGLIB", method = RequestMethod.GET)
	@ResponseBody
	public void cglibDynamicProxy() throws InterruptedException {

		userDaoProxyByCglib.add();
	}
}