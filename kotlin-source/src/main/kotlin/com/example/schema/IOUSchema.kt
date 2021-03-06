package com.example.schema

import net.corda.core.schemas.MappedSchema
import net.corda.core.schemas.PersistentState
import java.time.Instant
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * The family of schemas for IOUState.
 */
object IOUSchema

/**
 * An IOUState schema.
 */
object IOUSchemaV1 : MappedSchema(
        schemaFamily = IOUSchema.javaClass,
        version = 1,
        mappedTypes = listOf(PersistentIOU::class.java)) {
    @Entity
    @Table(name = "iou_states")
    class PersistentIOU(
            @Column(name = "lender")
            var lenderName: String,

            @Column(name = "borrower")
            var borrowerName: String = "",

            @Column(name = "value")
            var value: Int = 0,

            @Column(name = "dteDate")
            val dteDate: Instant = Instant.now(),

            @Column(name = "paymentValue")
            val paymentValue:Int = 0,

            @Column(name = "interest")
            val interest: Int = 0,

            @Column(name = "status")
            val status: String = "",

            @Column(name = "linear_id")
            var linearId: UUID = UUID.randomUUID()
    ) : PersistentState()
}