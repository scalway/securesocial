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
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext

/**
 * A mockable interface for the http client
 */
trait HttpService {

  import play.api.libs.ws.WSRequest

  def url(url: String): WSRequest
}

object HttpService {

  /**
   * A default implementation for HttpService based on the Play WS client.
   */
  class Default(implicit val executionContext: ExecutionContext) extends HttpService {
    @Inject
    implicit var application: Application = null
    @Inject
    implicit var WS: WSClient = null

    import play.api.libs.ws.WSRequest

    def url(url: String): WSRequest = WS.url(url)
  }

}
