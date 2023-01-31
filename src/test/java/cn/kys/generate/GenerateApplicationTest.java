package cn.kys.generate;

import cn.kys.generate.facade.GenerateFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 * 生成代码
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午4:16
 */
@SpringBootTest(classes = GenerateApplication.class, properties = "spring.profiles.active=t14")
public class GenerateApplicationTest {
    @Autowired
    private GenerateFacade generateFacade;

    @Test
    public void test(){
        generateFacade.run();
    }

    public static void main(String[] args) {
        String[] split = a.split("\\n");
        for (int i = 0; i < split.length; i++) {
            String b = split[i];
            String[] split1 = b.split("`");
            split1[1] = camel2under(split1[1]);
            b = split1[0] + "`" + split1[1]  + "`" + split1[2];
            System.out.println(b);
        }
    }

    /**
     * 功能：驼峰命名转下划线命名
     * 小写和大写紧挨一起的地方,加上分隔符,然后全部转小写
     */
    public static String camel2under(String c)
    {
        String separator = "_";
        c = c.replaceAll("([a-z])([A-Z])", "$1"+separator+"$2").toLowerCase();
        return c;
    }

    static String a = "\t`accountId` int COMMENT \"\",\n" +
            "\t`accountNick` varchar(40) COMMENT \"\",\n" +
            "\t`avgReplyDur1d` float(6,2) COMMENT \"平均响应时长（秒)\",\n" +
            "\t`avgReplyTime` float(6,2) COMMENT \"平均接待时长\",\n" +
            "\t`byrAskUv1d` int COMMENT \"买家发起人数\",\n" +
            "\t`byrMsgCnt1d` int COMMENT \"买家消息条数\",\n" +
            "\t`cpd` float(6,2) COMMENT \"\",\n" +
            "\t`cstSid1d` int COMMENT \"咨询客服人次\",\n" +
            "\t`cstUv1d` int COMMENT \"咨询人数\",\n" +
            "\t`dateId` varchar(40) COMMENT \"\",\n" +
            "\t`dirReplyUv1d` int COMMENT \"直接接待人数\",\n" +
            "\t`fstReplyDur1d` float(6,2) COMMENT \"首次响应时长（秒)\",\n" +
            "\t`longRecUv1d` int COMMENT \"长接待人数\",\n" +
            "\t`manReplyCnt1d` int COMMENT \"\",\n" +
            "\t`manReplyDur1d` int COMMENT \"\",\n" +
            "\t`msgCnt1d` int COMMENT \"客服消息条数\",\n" +
            "\t`onlineDur1d` int COMMENT \"\",\n" +
            "\t`psnNickName` varchar(40) COMMENT \"旺旺昵称\",\n" +
            "\t`qaRatio` float(6,2) COMMENT \"答问比\",\n" +
            "\t`replySid1d` int COMMENT \"客服回复人次\",\n" +
            "\t`replyUv1d` int COMMENT \"直接接待人数\",\n" +
            "\t`servAskUv1d` int COMMENT \"客服主动跟进人数\",\n" +
            "\t`servMsgCnt1d` int COMMENT \"客服消息条数\",\n" +
            "\t`servMsgLen1d` int COMMENT \"客服字数\",\n" +
            "\t`slowResUv1d` int COMMENT \"慢响应人数\",\n" +
            "\t`tranInReplyUv1d` int COMMENT \"转入人数\",\n" +
            "\t`tranOutReplyUv1d` int COMMENT \"转出人数\",\n" +
            "\t`unreplySid1d` int COMMENT \"客服未回复人次\",\n" +
            "\t`unreplyUv1d` int COMMENT \"未回复人数\",\n" +
            "\t`validReplyUv1d` int COMMENT \"有效接待人数\",\n" +
            "\t`wwReply` float(6,2) COMMENT \"旺旺回复率\",";
}
