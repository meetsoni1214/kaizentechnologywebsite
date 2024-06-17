package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.components.ServiceComponent
import com.example.kaizentechnology.models.Service
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint

@Composable
fun ServicesSection(
    breakpoint: Breakpoint
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth(),
        numColumns = numColumns(base = 1, md = 2, lg = 3),
    ) {
       Service.entries.forEach { service ->
           ServiceComponent(logo = service.logo, service = service.serviceName, breakpoint = breakpoint)
       }
    }
}