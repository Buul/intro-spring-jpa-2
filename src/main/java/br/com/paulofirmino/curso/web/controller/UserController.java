package br.com.paulofirmino.curso.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.paulofirmino.curso.dao.IUserDao;
import br.com.paulofirmino.curso.domain.GenderType;
import br.com.paulofirmino.curso.domain.UserModel;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserDao dao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listAll(ModelMap model) {
		model.addAttribute("users", dao.getAll());
		return new ModelAndView("/user/list", model);
	}

	@GetMapping("/add")
	public String add(@ModelAttribute("user") UserModel user, ModelMap model) {
		model.addAttribute("genders", GenderType.values());
		return "/user/add";
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("user") UserModel user, BindingResult result,
			RedirectAttributes attr) {
		
		if (result.hasErrors())
			return new ModelAndView("/user/add");
		dao.save(user);
		attr.addFlashAttribute("message", "User added successfully.");
		return new ModelAndView("redirect:/user/all");
	}

	@GetMapping("/get/{id}")
	public ModelAndView getUserById(@PathVariable("id") Long id, ModelMap model) {
		UserModel user = dao.getId(id);
		model.addAttribute("user", user);
		return new ModelAndView("user/add", model);
	}

	@PostMapping("update")
	public ModelAndView update(@Valid @ModelAttribute("user") UserModel user, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors())
			return new ModelAndView("/user/add");
		dao.update(user);
		attr.addFlashAttribute("message", "Update user successfully.");
		return new ModelAndView("redirect:/user/all");
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		dao.delete(id);
		attr.addFlashAttribute("message", "Delete user successfully.");
		return new ModelAndView("redirect:/user/all");
	}

}
