package com.netflix.hystrix

import rx.Observable

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Created by karellen.kim on 2018. 9. 17...
  */
trait HystrixCommand[A] {
  def run(): A
  def execute(): A = Await.result(queue(), Duration.Inf)
  def queue(): Future[A] = ???
  def observe(): Observable[A] = ???
}
