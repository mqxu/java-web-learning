package com.mqxu.bo.dao;

import com.mqxu.bo.entity.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-27
 **/
class BookDaoTest {

    @Test
    void selectAll() {
        List<Book> books = new BookDao().selectAll();
        assertEquals(6, books.size());
    }
}