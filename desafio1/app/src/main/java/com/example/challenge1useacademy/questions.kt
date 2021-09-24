package com.example.challenge1useacademy

class Question {
    var questionsSelected: ArrayList<Int> = arrayListOf()
    var questionsScore: ArrayList<Boolean> = arrayListOf()
    private var score: Int = 0

    val questions = arrayOf<DataQuestion>(
        DataQuestion(
            "Quem foi Napoleão?",
            listOf(
                "Um leão com nariz grande.",
                "Imperador na França",
                "Empreendedor no ramo de guardanapos",
                "Presidente francês"
            ),
            "Imperador na França"
        ),
        DataQuestion(
            "Quais as cores do arco-iris?",
            listOf(
                "violeta, anil, azul, verde, amarelo, laranja e vermelho",
                "branco, preto, azul, lilás, cinza, laranja e vermelho",
                "branco, anil, azul, verde, cinza, laranja e vermelho",
                "violeta, preto, azul, lilás, cinza, laranja e vermelho"
            ),
            "violeta, anil, azul, verde, amarelo, laranja e vermelho"
        ),
        DataQuestion(
            "Quantos oceanos tem o globo terrestre?",
            listOf(
                "4",
                "3",
                "7",
                "5"
            ),
            "5"
        ),
        DataQuestion(
            "Qual personagem é capturado com uma peneira e uma garrafa?",
            listOf(
                "Hulk",
                "Homem de Ferro",
                "Curupira",
                "Saci"
            ),
            "Saci"
        ),
        DataQuestion(
            "Quantas estrelas tem a bandeira do Brasil?",
            listOf(
                "26",
                "27",
                "28",
                "25"
            ),
            "27"
        ),
        DataQuestion(
            "De acordo com a sequência: U D T Q C S S, quais são as próximas 3 letras?",
            listOf(
                "U D Q",
                "O N D",
                "C S S",
                "A L D"
            ),
            "O N D"
        ),
        DataQuestion(
            "Onde foram realizados os primeiros jogos Olímepicos modernos?",
            listOf(
                "Paris",
                "Rio",
                "Roma",
                "Atena"
            ),
            "Atena"
        ),
        DataQuestion(
            "Quem é o(a) Deus(a) do amor na mitologia grega?",
            listOf(
                "Eros",
                "Afrodite",
                "Poseidon",
                "Átemis"
            ),
            "Eros"
        ),
        DataQuestion(
            "Alexandre, o grande, foi rei na cidade de?",
            listOf(
                "Macedônia",
                "Roma",
                "Moscou",
                "Marselha"
            ),
            "Macedônia",
        ),
        DataQuestion(
            "Qual o médico que cuida dos pés?",
            listOf(
                "Pediatra",
                "Ortopedista",
                "Otorrinolaringologista",
                "Neurologista"
            ),
            "Ortopedista"
        )
    )

    fun sortQuestion(): DataQuestion {
        var random: Int = (0 until questions.size).random()
        while (!checkQuestion(random)) {
            random = (0 until questions.size).random()
        }

        return questions[random]
    }

    fun checkQuestion(num: Int): Boolean {
        if (questionsSelected.contains(num)) {
            return false
        }
        questionsSelected.add(num)
        return true
    }

    fun removeAllQuestions() {
        while(questionsSelected.size > 1){
            questionsSelected.clear()
            questionsScore.clear()
        }
    }

    fun getLastQuestion(): DataQuestion {
        questionsSelected.removeAt(questionsSelected.size - 1)
        if(questionsScore[questionsScore.size - 1]) {
            score--
        }
        questionsScore.removeAt(questionsScore.size - 1)
        return questions[questionsSelected[questionsSelected.size - 1]]
    }

    fun questionRight() {
        questionsScore.add(true)
        score++
    }

    fun questionWrong() {
        questionsScore.add(false)
    }

    fun getScore(): Int {
        return score
    }
}

data class DataQuestion(
    val question: String,
    var options: List<String> = ArrayList<String>(4),
    val answer: String
)