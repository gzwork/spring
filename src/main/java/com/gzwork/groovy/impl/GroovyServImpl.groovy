package com.gzwork.groovy.impl;

import com.gzwork.groovy.GroovyServ;

class GroovyServImpl implements GroovyServ {


    @Override
    String say(String string) {
        return String.format("Helllo\t%s", string);
    }
}
