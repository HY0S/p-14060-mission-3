package com.back.domain.wiseSaying.controller;


//하는 일 : 명언 등록, 명언 리스트 반환, 명언 제거, 명언 수정, Json 빌드 명령

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private WiseSayingService wiseSayingService;
    private Scanner scanner;

    public WiseSayingController(Scanner scanner) {
        this.wiseSayingService = new WiseSayingService();
        this.scanner = scanner;
    }

    public void write(){
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        int id = wiseSayingService.write(content,author);
        System.out.println(id+ "번 명언이 등록되었습니다.");
    }

    public void list(){
        List<WiseSaying> wiseSayingList = wiseSayingService.list();
        System.out.println("번호 / 작가 / 명언\n----------------------");
        for (WiseSaying ws : wiseSayingList) {
            System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
        }
    }

    public void remove(String command){
        String numbersOnly = command.replaceAll("[^0-9]", "");
        int id = Integer.parseInt(numbersOnly);
        if(WiseSayingService.remove(id)){
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
        else{
            System.out.println(id+ "번 명언은 존재하지 않습니다.");
        }
    }

    public void modify(String command){
        String numbersOnly = command.replaceAll("[^0-9]", "");
        int id = Integer.parseInt(numbersOnly);

        WiseSaying w = WiseSayingService.read(id);

        if(w != null){
            System.out.println("명언(기존) " + w.getContent());
            System.out.print("명언 : ");
            String content = scanner.nextLine();


            System.out.println("작가(기존) " + w.getAuthor());
            System.out.print("작가 : ");
            String author = scanner.nextLine();

            WiseSayingService.modify(id,content,author);
        }
        else{
            System.out.println(id+ "번 명언은 존재하지 않습니다.");
        }
    }

    public void build(){
        WiseSayingService.build();
    }
}
