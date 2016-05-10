/**
 * Copyright 2013-2014 Jorge Aliss (jaliss at gmail dot com) - twitter: @jaliss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package securesocial.core.services

import javax.inject.Inject

import play.api.Application
import play.api.cache.CacheApi

import scala.concurrent.duration.Duration
import scala.concurrent.{ ExecutionContext, Future }

/**
 * An interface for the Cache API
 */
trait CacheService {

  import scala.reflect.ClassTag

  def set[T](key: String, value: T, ttlInSeconds: Int = 0): Future[Unit]

  def getAs[T](key: String)(implicit ct: ClassTag[T]): Future[Option[T]]

  def remove(key: String): Future[Unit]
}

object CacheService {

  /**
   * A default implementation for the CacheService based on the Play cache.
   */
  class Default(implicit val executionContext: ExecutionContext) extends CacheService {

    import scala.reflect.ClassTag

    @Inject
    implicit var application: Application = null
    @Inject
    implicit var Cache: CacheApi = null

    override def set[T](key: String, value: T, ttlInSeconds: Int): Future[Unit] =
      Future.successful(Cache.set(key, value, Duration(ttlInSeconds, "s")))

    override def getAs[T](key: String)(implicit ct: ClassTag[T]): Future[Option[T]] = Future.successful {
      Cache.get[T](key)
    }

    override def remove(key: String): Future[Unit] = Future.successful {
      Cache.remove(key)
    }
  }

}
