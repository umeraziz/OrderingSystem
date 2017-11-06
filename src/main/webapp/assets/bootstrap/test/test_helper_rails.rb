ENV['RAILS_ENV'] = ENV['RACK_ENV'] = 'test'

require 'test_helper'
require 'dummy_rails/com.optp.config/environment'
require 'rails/test_help'
require 'capybara/rails'
