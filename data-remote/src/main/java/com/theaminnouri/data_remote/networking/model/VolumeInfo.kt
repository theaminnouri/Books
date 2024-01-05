package com.theaminnouri.data_remote.networking.model

import com.squareup.moshi.Json


data class VolumeInfo(
    @Json(name = "title") var title: String? = null,
    @Json(name = "subtitle") var subtitle: String? = null,
    @Json(name = "authors") var authors: ArrayList<String> = arrayListOf(),
    @Json(name = "publisher") var publisher: String? = null,
    @Json(name = "publishedDate") var publishedDate: String? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "industryIdentifiers") var industryIdentifiers: ArrayList<IndustryIdentifiers> = arrayListOf(),
    @Json(name = "readingModes") var readingModes: ReadingModes? = ReadingModes(),
    @Json(name = "pageCount") var pageCount: Int? = null,
    @Json(name = "printedPageCount") var printedPageCount: Int? = null,
    @Json(name = "printType") var printType: String? = null,
    @Json(name = "categories") var categories: ArrayList<String> = arrayListOf(),
    @Json(name = "maturityRating") var maturityRating: String? = null,
    @Json(name = "allowAnonLogging") var allowAnonLogging: Boolean? = null,
    @Json(name = "contentVersion") var contentVersion: String? = null,
    @Json(name = "panelizationSummary") var panelizationSummary: PanelizationSummary? = PanelizationSummary(),
    @Json(name = "imageLinks") var imageLinks: ImageLinks? = ImageLinks(),
    @Json(name = "language") var language: String? = null,
    @Json(name = "previewLink") var previewLink: String? = null,
    @Json(name = "infoLink") var infoLink: String? = null,
    @Json(name = "canonicalVolumeLink") var canonicalVolumeLink: String? = null

)
