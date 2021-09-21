package com.example.challenge1useacademy

class Question {
    val questions = arrayOf<DataQuestion>(
        DataQuestion(
            "Quem foi Napoleão?",
            "Um leão com nariz grande.",
            "Imperador na França",
            "Empreendedor no ramo de guardanapos",
            "Presidente francês",
            "Imperador na França"
        ),
        DataQuestion(
            "Quais as cores do arco-iris?",
            "violeta, anil, azul, verde, amarelo, laranja e vermelho",
            "branco, preto, azul, lilás, cinza, laranja e vermelho",
            "branco, anil, azul, verde, cinza, laranja e vermelho",
            "violeta, preto, azul, lilás, cinza, laranja e vermelho",
            "violeta, anil, azul, verde, amarelo, laranja e vermelho"
        ),
        DataQuestion(
            "Quantos oceanos tem o globo terrestre?",
            "4",
            "3",
            "7",
            "5",
            "5"
        ),
        DataQuestion(
            "Qual personagem é capturado com uma peneira e uma garrafa?",
            "Hulk",
            "Homem de Ferro",
            "Curupira",
            "Saci",
            "Saci"
        ),
        DataQuestion(
            "Quantas estrelas tem a bandeira do Brasil?",
            "26",
            "27",
            "28",
            "25",
            "26"
        ),
        DataQuestion(
            "De acordo com a sequência: U D T Q C S S, quais são as próximas 3 letras?",
            "U D Q",
            "O N D",
            "C S S",
            "A L D",
            "O N D"
        ),
        DataQuestion(
            "Onde foram realizados os primeiros jogos Olímepicos modernos?",
            "Paris",
            "Rio",
            "Roma",
            "Atena",
            "Atena"
        ),
        DataQuestion(
            "Quem é o(a) Deus(a) do amor na mitologia grega?",
            "Eros",
            "Afrodite",
            "Poseidon",
            "Átemis",
            "Eros"
        ),
        DataQuestion(
            "Alexandre, o grande, foi rei na cidade de?",
            "Macedônia",
            "Roma",
            "Moscou",
            "Marselha",
            "Macedônia",
        ),
        DataQuestion(
            "Qual o médico que cuida dos pés?",
            "Pediatra",
            "Ortopedista",
            "Otorrinolaringologista",
            "Neurologista",
            "Ortopedista"
        )
    )
}

data class DataQuestion(
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val answer: String,
)