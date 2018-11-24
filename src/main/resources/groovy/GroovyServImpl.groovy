
import com.gzwork.groovy.GroovyServ;

class GroovyServImpl implements GroovyServ {

    @Override
    String say(String string) {
        return String.format("Hello\t%s", string);
    }
}
