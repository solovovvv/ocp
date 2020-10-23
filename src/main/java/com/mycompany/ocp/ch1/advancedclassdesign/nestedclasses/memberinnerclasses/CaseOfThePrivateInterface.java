package com.mycompany.ocp.ch1.advancedclassdesign.nestedclasses.memberinnerclasses;

//интерфейс в классе может быть private, но методы нет и как всегда реализация во внутреннем классе этих методов
//должна быть public
public class CaseOfThePrivateInterface {
    private interface Secret {
        void shh();
    }

    class DontTell implements Secret {
        public void shh() {
        }
    }
}
