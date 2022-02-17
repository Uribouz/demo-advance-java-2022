package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public static final int IS_FOUND = 1;

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        String[] domains = {"gmail.com", "live.com"};
        Integer speakerId;
        validateSpeaker(speaker);

        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != IS_FOUND) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
        int exp = speaker.getExp();
        speaker.setRegistrationFee(getFee(exp));
        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    int getFee(int experienceYear) {
        int fee = 0;
        if (experienceYear <= 1) {
            fee = 500;
        } else if (experienceYear <= 3) {
            fee = 250;
        } else if (experienceYear <= 5) {
            fee = 100;
        } else if (experienceYear <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException("Email's domain is required.");
    }

    private void validateSpeaker(Speaker speaker) {
        if(speaker ==null) {
            throw new RuntimeException("speaker is null");
        }
        speaker.validate();
    }
}