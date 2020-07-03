/**
 * Project Name:fire-industry-map
 * File Name:GeneratorServiceEntity.java
 * Package Name:com.firestone.generator
 * Date:2018年7月5日下午8:20:45
 */

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.demo.webadmin.common.BaseController;
import org.junit.Test;

/**
 * @author lvxc
 * @Description: 代码自动生成工具
 * @date 2018年7月5日 下午8:20:45
 */
public class GeneratorServiceEntity {

	private final static ITypeConvert MYSQL_TYPE_CONVERT = fieldType -> {
		String t = fieldType.toLowerCase();
		if (t.contains("char") || t.contains("text")) {
			return DbColumnType.STRING;
		} else if (t.contains("bigint")) {
			return DbColumnType.LONG;
		} else if (t.contains("int")) {
			return DbColumnType.LONG;
		} else if (t.contains("date") || t.contains("time") || t.contains("year")) {
			return DbColumnType.DATE;
		} else if (t.contains("text")) {
			return DbColumnType.STRING;
		} else if (t.contains("bit")) {
			return DbColumnType.BOOLEAN;
		} else if (t.contains("decimal")) {
			return DbColumnType.BIG_DECIMAL;
		} else if (t.contains("clob")) {
			return DbColumnType.CLOB;
		} else if (t.contains("blob")) {
			return DbColumnType.BLOB;
		} else if (t.contains("binary")) {
			return DbColumnType.BYTE_ARRAY;
		} else if (t.contains("float")) {
			return DbColumnType.FLOAT;
		} else if (t.contains("double")) {
			return DbColumnType.DOUBLE;
		} else if (t.contains("json") || t.contains("enum")) {
			return DbColumnType.STRING;
		}
		return DbColumnType.STRING;
	};

	@Test
	public void generateCode() {
		String packageName = "com.demo.webadmin";
		boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
		generateByTables(serviceNameStartWithI, packageName, "t_user");
	}

	private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
		GlobalConfig config = new GlobalConfig();
		config.setEnableCache(false);// XML 二级缓存
		config.setBaseResultMap(true);// XML ResultMap
		config.setBaseColumnList(true);// XML columList
		String dbUrl = "jdbc:mysql://192.168.203.101:3306/web-admin?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
				.setUrl(dbUrl)
				.setUsername("root")
				.setPassword("chennewtoo_")
				.setTypeConvert(MYSQL_TYPE_CONVERT)
				.setDriverName("com.mysql.jdbc.Driver");
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig
				.setRestControllerStyle(true) // restController
				.setCapitalMode(true)
				.setTablePrefix(new String[]{"t_"})// 此处可以修改为您的表前缀
			//	.setLogicDeleteFieldName("deleted")
				.setEntityLombokModel(true)
				.setDbColumnUnderline(true)
				.setControllerMappingHyphenStyle(true)
				.setSuperEntityClass("com.firestone.common.dto.BaseBean")
				.setSuperEntityColumns("id", "create_user_id", "create_time", "update_user_id", "update_time")
				.setSuperControllerClass(BaseController.class.getCanonicalName())
				.setNaming(NamingStrategy.underline_to_camel) //表名生成策略
				.setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
		config.setActiveRecord(false)
				.setAuthor("chen.chao")
				.setOutputDir(System.getProperty("user.dir"))
				.setFileOverride(false);
		if (!serviceNameStartWithI) {
			config.setServiceName("%sService");
		}
		new AutoGenerator().setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(
						new PackageConfig()
								.setParent(packageName)
//                                .setController("server")
							//	.setEntity("bean.mysql")
							//	.setMapper("dao.mysql")
				).execute();
	}

//    private void generateByTables(String packageName, String... tableNames) {
//        generateByTables(true, packageName, tableNames);
//    }
}

