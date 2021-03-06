/**
 * Copyright 2014 Jorge Aliss (jaliss at gmail dot com) - twitter: @jaliss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package securesocial.core.java;

import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Html;

import java.util.concurrent.CompletionStage;

/**
 * An interface that defines the responses that will be sent wheen the invoker is not authenticated or
 * authorized to execute a protected action.
 *
 * @see securesocial.core.java.DefaultSecuredActionResponses
 */
public interface SecuredActionResponses {
    Html notAuthorizedPage(Http.Context ctx);

    CompletionStage<Result> notAuthenticatedResult(Http.Context ctx);

    CompletionStage<Result> notAuthorizedResult(Http.Context ctx);
}
