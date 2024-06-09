package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.components.ProductComponent
import com.example.kaizentechnology.models.Product
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun ProductsSection(
    breakpoint: Breakpoint
) {
    Box(
        modifier = Modifier
            .padding(left = if (breakpoint > Breakpoint.SM) 60.px else 44.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(),
            numColumns = numColumns(base = 1, sm = 2, md = 3, lg = 4)
        ) {
            Product.entries.forEach { product ->
                ProductComponent(product = product)
            }
        }
    }
}