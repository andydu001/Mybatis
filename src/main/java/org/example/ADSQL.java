package org.example;

import org.apache.ibatis.session.Configuration;

import org.apache.ibatis.builder.BaseBuilder;
public class ADSQL extends BaseBuilder{


    public ADSQL(Configuration configuration) {

        super(configuration);

       System.out.println(configuration.getDatabaseId());

    }

}
