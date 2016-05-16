package com.websystique.springmvc.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

import bsh.Console;

import com.websystique.springmvc.model.Article;
import com.websystique.springmvc.service.ArticleService;

@Controller
@RequestMapping(value = { "/" })
public class RegistrationController {

	@Autowired
	private ArticleService articleService;	
	
	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	
	/*****************************USERS_START*******************************/
	/*
	 * This method will provide the medium to add a new User.
	 */
	@RequestMapping(value = { "/registrationUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "users/registrationUser";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/registrationUser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
		DateTimeFormatter dateFormat = DateTimeFormat.forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");

		String dob = "2002-01-15";
		LocalTime localTime = new LocalTime();
		LocalDate localDate = new LocalDate();
		DateTime dateTime = new DateTime();
		LocalDateTime localDateTime = new LocalDateTime();
		DateTimeZone dateTimeZone = DateTimeZone.getDefault();

		user.setCreationDate(localDate);
		
		System.out.println(user.getCreationDate());
		
		user.setDeleted(false);
		user.setRating(0);

		if (result.hasErrors()) {
			return "users/registrationUser";
		}

		/*
		 * Preferred way to achieve uniqueness of field [email] should be
		 * implementing custom @Unique annotation and applying it on field
		 * [email] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 * 
		 */
		if (!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
			FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email",
					new String[] { user.getEmail() }, Locale.getDefault()));
			result.addError(emailError);
			return "registrationUser";
		}

		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getName() + " Registered Successfully");
		return "successUser";
	}
	/*****************************USERS_END*********************************/
}
