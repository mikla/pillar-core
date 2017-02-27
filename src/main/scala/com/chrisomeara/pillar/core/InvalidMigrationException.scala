package com.chrisomeara.pillar.core

class InvalidMigrationException(val errors: Map[String,String]) extends RuntimeException
