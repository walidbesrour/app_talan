package com.example.talan_app.model

class Journal {
    var n_journal :String = ""
    var datajournal :String = ""
    var typejournal : String = ""
    var creejournal : String = ""

    constructor(n_journal: String, datajournal: String, typejournal: String, creejournal: String) {
        this.n_journal = n_journal
        this.datajournal = datajournal
        this.typejournal = typejournal
        this.creejournal = creejournal
    }
}