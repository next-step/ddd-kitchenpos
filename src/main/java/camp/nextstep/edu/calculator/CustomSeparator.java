package camp.nextstep.edu.calculator;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.calculator.CustomSeparator.CustomSeparatorType.PREFIX_MARK;
import static camp.nextstep.edu.calculator.CustomSeparator.CustomSeparatorType.SUFFIX_MARK;

public class CustomSeparator implements Separator {

    private static Pattern pattern = Pattern.compile(PREFIX_MARK.getMark() + "(.)" + SUFFIX_MARK.getMark() + "(.*)");

    @Override
    public CalculateInfo getCalculateInfo(String input) {

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return CalculateInfo.getInstance(Collections.singletonList(matcher.group(1)), matcher.group(2));
        }

        return CalculateInfo.getInstance();
    }

    enum CustomSeparatorType {

        PREFIX_MARK("//"),
        SUFFIX_MARK("\n");

        CustomSeparatorType(String mark) {
            this.mark = mark;
        }

        private String mark;

        public String getMark() {
            return mark;
        }
    }
}
