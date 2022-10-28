package org.Online_Shop.dao.impl;


import org.Online_Shop.dao.CategoryDao;
import org.Online_Shop.dto.CategoryDto;
import org.Online_Shop.utils.db.DBUtils;

import java.sql.SQLException;

public class MySqlJdbcCategoryDao implements CategoryDao {

	@Override
	public CategoryDto getCategoryByCategoryId(int id) {
		try (var conn = DBUtils.getConnection();
			 var ps = conn.prepareStatement("SELECT * FROM category WHERE id = ?")) {
			
			ps.setInt(1, id);
			
			try (var rs = ps.executeQuery()) {
				if (rs.next()) {
					CategoryDto category = new CategoryDto();
					category.setId(rs.getInt("id"));
					category.setCategoryName(rs.getString("category_name"));
					return category;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
