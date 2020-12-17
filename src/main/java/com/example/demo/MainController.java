package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	TravelDataRepository repository;
//	会員登録
	@RequestMapping(value="/travel", method = RequestMethod.GET)
	public ModelAndView travelGet(ModelAndView mv){
	List<TravelData> customers = repository.findAll();
	mv.addObject("customers", customers);
	mv.setViewName("travel");
	return mv;
	}
	@RequestMapping(value="/travel", method = RequestMethod.POST)
	public ModelAndView travelPost(@ModelAttribute("formModel") TravelData//入力データを受け取る
	TravelData, ModelAndView mv){
	repository.saveAndFlush(TravelData);//入力データをテーブルに送る
	return new ModelAndView("redirect:/completion");
	}
	
//　　ツイート
	@Autowired
	TravelHomeDataRepository repository1;
	@RequestMapping(value="/travelhome", method = RequestMethod.GET)
	public ModelAndView travelhomeGet(ModelAndView mv){
	List<TravelHomeData> tweet = repository1.findAll();
	List<TravelData> customers = repository.findAll();
	mv.addObject("tweet", tweet);
	mv.addObject("customers", customers);
	mv.setViewName("travelhome");
	return mv;
	}
	@RequestMapping(value="/travelhome", method = RequestMethod.POST)
	public ModelAndView travelhomePost(@ModelAttribute("formModel") TravelHomeData
	TravelHomeData, ModelAndView mv){
	Date dateObj = new Date();
	SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );  
	String display = format.format( dateObj );
	String date=display;
	TravelHomeData.setDate(date);
	repository1.saveAndFlush(TravelHomeData);
	return new ModelAndView("redirect:/travelhome");
	}
//	ログインページ
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPost(ModelAndView mv){
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value="/completion", method=RequestMethod.GET)
	public ModelAndView completionPost(ModelAndView mv){
		mv.setViewName("completion");
		return mv;
	}
}
