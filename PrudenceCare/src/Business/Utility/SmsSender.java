
package Business.Utility;


/**
 *
 * @author rishabagarwal
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACcf2d9b859e2875bdef1a65b24ef05c3c";
    public static final String AUTH_TOKEN =
            "43469b44217990cffa2c9c33429bccb5";

    public static void sendSms(String toPhone, String msg) {
        System.out.println("Start");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        System.out.println("Start");
        Message message = Message
                .creator(new PhoneNumber("+1"+toPhone), // to
                               //         .creator(new PhoneNumber(toPhone), // to

                        new PhoneNumber("+18058192861"), // from
                        msg)
                .create();
System.out.println("end");
        System.out.println(message.getSid());
    }
}