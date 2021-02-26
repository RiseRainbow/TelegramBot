import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

public class Bot extends TelegramLongPollingBot {

    public final DeviceInfo deviceInfo = new DeviceInfo();


    @Override
    public String getBotUsername() {
        return "Devicer_myak_bot";
    }

    @Override
    public String getBotToken() {
        return "1667221415:AAFrfvY5mRoL2e1C-1rt2O4AJJWrVwMV4_o";
    }

    @Override
    public void onUpdateReceived(Update update) {
// We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            var message = SendMessage.builder()
                    .chatId(String.valueOf(update.getMessage().getChatId()))
                    .text(deviceInfo.getMore(update.getMessage().getText()))
                    .build();
            //System.out.println(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            /*var message = SendMessage.builder() // Create a SendMessage object with mandatory fields
                    .chatId(String.valueOf(update.getMessage().getChatId()))
                    .text(update.getMessage().getText())
                    .build();
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }*/
        }
    }
}
