package com.mycompany.ocp.ch3.genericsandcollections.streamapi.misc;

public class ParallelDemo {
    public static void main(String[] args) {
        //Внимание: крайне не рекомендуется использовать параллельные стримы для сколько-нибудь долгих операций
        // (получение данных из базы, сетевых соединений), так как все параллельные стримы работают c одним пулом
        // fork/join и такие долгие операции могут остановить работу всех параллельных стримов в JVM из-за того
        // отсутствия доступных потоков в пуле, т.е. параллельные стримы стоит использовать лишь для коротких операций,
        // где счет идет на миллисекунды, но не для тех где счет может идти на секунды и минуты.





    }
}
