package com.mqxu.bo.dao;

import com.mqxu.bo.entity.Book;
import com.mqxu.bo.entity.User;
import com.mqxu.bo.util.JdbcUtil;
import com.mqxu.bo.utils.Md5Util;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @description: 操作数据库中book表的类
 * @author: mqxu
 * @date: 2022-02-27
 **/
public class BookDao {
    /**
     * 声明JDBCTemplate对象
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    /**
     * 获取所有图书
     *
     * @return List<Book>
     */
    public List<Book> selectAll() {
        try {
            String sql = "SELECT * FROM t_book ORDER BY id DESC ";
            return template.query(sql, new BeanPropertyRowMapper<>(Book.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBookById(int id) {
        try {
            String sql = "SELECT * FROM t_book WHERE id = ? ";
            return template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Book.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
