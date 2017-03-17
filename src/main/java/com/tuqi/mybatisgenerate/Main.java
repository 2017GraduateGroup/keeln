package com.tuqi.mybatisgenerate;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

/**
 * mybatisgen main.
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {
        /**
         * 注意：对于多数据源的情况，生成表时需要确定4个要素：
         * 1、实体类对应的表名，修改在fiat_generate_tables.config文件中
         * 2、对应数据库的前缀，修改在MyBatisGenConst.tablePrefix
         * 3、不同数据库存储路径变量，修改在修改在MyBatisGenConst.mapLocation
         * 4、数据源配置信息，如db_fiat.config
         */

        // 需要生成的表配置文件在generate_tables.config文件中，每每行一个表名
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("fiat_generate_tables.config");
        List<String> tables = IOUtils.readLines(inputStream, Charset.forName("UTF-8"));
        System.out.println("========== 表名 start ==========");
        for (String str: tables){
            System.out.println(str);
        }
        System.out.println("========== 表名   end ==========");
        if (CollectionUtils.isEmpty(tables)) {
            System.out.println("fiat_generate_tables.config is empty.");
            return;
        }
        System.out.println("is generating ...");
        MyBatisGenCore.batchGen(tables, "db_tuqi.config");
        System.out.print("done!");
    }
}