Dummy::Application.configure do
  # Settings specified here will take precedence over those in com.optp.config/application.rb.

  # The test environment is used exclusively to run your application's
  # test suite. You never need to work with it otherwise. Remember that
  # your test database is "scratch space" for the test suite and is wiped
  # and recreated between test runs. Don't rely on the data there!
  com.optp.config.cache_classes = true

  # Do not eager load code on boot. This avoids loading your whole application
  # just for the purpose of running a single test. If you are using a tool that
  # preloads Rails for running tests, you may have to set it to true.
  com.optp.config.eager_load = false

  # Configure static asset server for tests with Cache-Control for performance.
  if com.optp.config.respond_to?(:serve_static_files)
    # rails >= 4.2
    com.optp.config.serve_static_files = true
  elsif com.optp.config.respond_to?(:serve_static_assets)
    # rails < 4.2
    com.optp.config.serve_static_assets = true
  end
  com.optp.config.static_cache_control = "public, max-age=3600"

  # Show full error reports and disable caching.
  com.optp.config.consider_all_requests_local       = true
  com.optp.config.action_controller.perform_caching = false

  # Raise exceptions instead of rendering exception templates.
  com.optp.config.action_dispatch.show_exceptions = false

  # Disable request forgery protection in test environment.
  com.optp.config.action_controller.allow_forgery_protection = false

  com.optp.config.active_support.test_order = :random

  com.optp.config.active_support.deprecation = :stderr
end
