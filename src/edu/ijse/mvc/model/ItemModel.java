/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.CustomerDto;
import edu.ijse.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anjanathrishakya
 */
public class ItemModel {

    public ItemDto searchItem(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);

        ResultSet rst = statement.executeQuery();

        ItemDto dto = null;
        while (rst.next()) {
            dto = new ItemDto();

            dto.setId(rst.getString("ItemCode"));
            dto.setDescription(rst.getString("Description"));
            dto.setPack(rst.getString("PackSize"));
            dto.setUnitPrice(rst.getDouble("UnitPrice"));
            dto.setQoh(rst.getInt("QtyOnHand"));
        }

        return dto;
    }
}
