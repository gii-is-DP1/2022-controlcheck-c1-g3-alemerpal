package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    private RecoveryRoomService service;

    @Autowired
    public RecoveryRoomTypeFormatter(RecoveryRoomService service) {
        this.service = service;
    }

    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.name;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        RecoveryRoomType type = service.getRecoveryRoomType(text);
        if (type == null) {
            throw new ParseException(text, 0);
        } else {
            return type;
        }
    }
}
