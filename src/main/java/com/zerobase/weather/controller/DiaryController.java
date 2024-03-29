package com.zerobase.weather.controller;

import com.zerobase.weather.domain.Diary;
import com.zerobase.weather.service.DiaryService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {

	private final DiaryService diaryService;

	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}


	@PostMapping("/create/diary")
	public void createDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date, @RequestBody String text) {
		diaryService.createDiary(date, text);
	}

	@GetMapping("/read/diary")
	public List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		return diaryService.readDiary(date);
	}

	@GetMapping("/read/diaries")
	public List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate endDate) {
		return diaryService.readDiaries(startDate, endDate);
	}

	@PutMapping("/update/diary")
	public void updateDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date, @RequestBody String text) {
		diaryService.updateDiary(date, text);
	}

	@DeleteMapping("/delete/diary")
	public void deleteDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		diaryService.deleteDiary(date);
	}

}
