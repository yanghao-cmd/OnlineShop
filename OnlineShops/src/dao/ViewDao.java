package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import domain.View;
import utils.DataSourceUtils;

public class ViewDao {
	//
	public void addView(View v) throws SQLException {

		String sql = "insert into view(vNo,id,type,time) "
				+ "values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, v.getvNo(), v.getId(), v.getType(), v.getTime());
	}
	
	
	public List<View> findViewByManyCondition(String id, String category)
			throws SQLException {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from view where 1=1 ";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if (id != null && id.trim().length() > 0) {
			sql += " and vNo=?";
			list.add(id);
		}

		if (category != null && category.trim().length() > 0) {
			sql += " and type=?";
			list.add(category);
		}


		Object[] params = list.toArray();
		return runner.query(sql, new BeanListHandler<View>(View.class),
				params);
	}
}

