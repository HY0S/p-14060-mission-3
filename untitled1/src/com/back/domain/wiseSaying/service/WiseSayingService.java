package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    private static WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public static boolean remove(int id) {
        return WiseSayingRepository.remove(id);
    }

    public static void build() {
        WiseSayingRepository.build();
    }

    public int write(String content, String author) { //명언을 등록하기

        wiseSayingRepository.write(content,author);

        int id = wiseSayingRepository.getLastIdFromFile();
        return id;
    }

    public static WiseSaying read(int id) {
        return wiseSayingRepository.read(id);
    }


    public List<WiseSaying> list() {
        return wiseSayingRepository.getWiseSayingList();
    }

    public static void modify(int id, String content, String author) {
        wiseSayingRepository.modify(id,content,author);
    }
}
