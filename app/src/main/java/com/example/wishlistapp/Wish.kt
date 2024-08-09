package com.example.wishlistapp

data class Wish(
    val id : Long = 0L,
    val title : String = "",
    val description : String = ""
)

object DummyWishList {
    val wishList = listOf(
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        ),
        Wish(
            title = "Google watech",
            description = "An android watch"
        )
    )
}
