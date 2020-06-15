package com.mysql.dao;

import com.mysql.db.DBUtil;
import com.mysql.entity.Biquge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BiQuGeDao {

    //第一层获取标题、作者、简介、图片
    public void addBooks(Biquge book) throws SQLException {

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into biquge (title,author,info,image)values(?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,book.getTitle());
        ptmt.setString(2,book.getAuthor());
        ptmt.setString(3,book.getInfo());
        ptmt.setString(4,book.getImage());

        ptmt.execute();
    }

    //第二层获取书籍的章节及内容
    public void addBook(Biquge book) throws SQLException {

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into biquge_2 (chapter,content)values(?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,book.getChapter());
        ptmt.setString(2,book.getContent());

        ptmt.execute();
    }
}
