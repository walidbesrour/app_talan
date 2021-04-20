package com.example.talan_app.model

class Articles {
    var CodeArticles : String = ""
    var DescriptionArticles :  String = ""
    var QuantiteArticles : String = ""
    var UniteArticles : String = ""

    constructor(CodeArticles: String, DescriptionArticles: String, QuantiteArticles: String, UniteArticles: String) {
        this.CodeArticles = CodeArticles
        this.DescriptionArticles = DescriptionArticles
        this.QuantiteArticles = QuantiteArticles
        this.UniteArticles = UniteArticles
    }
}