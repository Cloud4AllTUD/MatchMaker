package hello;

import java.sql.ResultSet;

import com.openrules.tools.DbUtil;

public class TestDB extends DbUtil {

	static public class OpenRulesDbEnv extends DbEnv {
		public OpenRulesDbEnv() {
			super();
			dsn = "TestDB";
		}
	}

	public TestDB() {
		super(new OpenRulesDbEnv());
	}

	public ResultSet openTable(String tableName) {
		try {
			String sql = "SELECT * FROM " + tableName;
			ResultSet rs = executeQuery(sql);
			return rs;
		} catch (Exception e) {
			String msg = "ERROR opening OpenRulesDB table " + tableName + "\n"
					+ e.toString();
			System.err.println();
			throw new RuntimeException(msg);
		}
	}
	
	public Customer nextCustomer(ResultSet rs) {
		try {
			if (!rs.next())
				return null;
			Customer customer = new Customer();
			customer.setName(rs.getString("CustomerName"));
			customer.setMaritalStatus(rs.getString("MaritalStatus"));
			customer.setGender(rs.getString("Gender"));
			customer.setAge(rs.getInt("Age"));
			return customer;
		} catch (Exception e) {
			String msg = "ERROR reading a customer from DB";
			System.err.println();
			throw new RuntimeException(msg);
		}
		
	}

	public void closeTable(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException("Cannot close ruleset");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestDB db = new TestDB();
		ResultSet rs = db.openTable("Customers");
		Customer customer;
		while((customer = db.nextCustomer(rs)) != null) {
			System.out.println("" + customer);
		}
		db.closeTable(rs);
	}

}
