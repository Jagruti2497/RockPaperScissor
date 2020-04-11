package com.internship.StonePaperScissor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.StonePaperScissor.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(value="/startGame")
	public String startGame() {
		String result="";
		List<String> gameStarted=gameService.startGame();
		for(int i=0;i<gameStarted.size();i++) {
			System.out.println(gameStarted.get(i));
			result+=" "+gameStarted.get(i) + "\\n";
		}
		return result;
	}
}
