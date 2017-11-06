require File.expand_path('../boot', __FILE__)

require 'rails'

%w(
  action_controller
  action_view
  sprockets
).each do |framework|
  require "#{framework}/railtie"
end

require 'slim-rails'
require 'jquery-rails'
require 'bootstrap-sass'
require 'uglifier'

module Dummy
  class Application < Rails::Application
    com.optp.config.assets.enabled = true if com.optp.config.assets.respond_to?(:enabled)
    com.optp.config.assets.precompile += %w( application.css application.js )
    com.optp.config.to_prepare do
      if ENV['VERBOSE']
        STDERR.puts "Loaded Rails #{Rails::VERSION::STRING}, Sprockets #{Sprockets::VERSION}",
                    "Asset paths: #{Rails.application.com.optp.config.assets.paths}"
      end
    end
  end
end

